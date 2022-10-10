package np.com.aayushgautam.believe.SelfHelp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import np.com.aayushgautam.believe.R;
import np.com.aayushgautam.believe.databinding.BlogRecyclerBinding;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.BlogViewHolder> {

    private ArrayList<BlogModel> blogModels;
    private Context context;

    public BlogAdapter(ArrayList<BlogModel> blogModels, Context context) {
        this.blogModels = blogModels;
        this.context = context;
    }

    @NonNull
    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blog_recycler,parent,false);
        return new BlogAdapter.BlogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BlogViewHolder holder, int position) {
        BlogModel blogModel = blogModels.get(position);

        final String content = blogModel.getContent();
        final String title = blogModel.getTitle();
        final String author = blogModel.getAuthor();
        String preview = blogModel.getPreview();

        holder.binding.author.setText(author);
        holder.binding.preview.setText(preview);
        holder.binding.blogTitle.setText(title);

        holder.binding.cardBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.binding.dropdownItems.getVisibility()==View.VISIBLE){
                    holder.binding.arrowDown.setImageResource(R.drawable.ic_arrow_down);
                    holder.binding.dropdownItems.setVisibility(View.GONE);
                } else {
                    holder.binding.arrowDown.setImageResource(R.drawable.ic_arrow_up);
                    holder.binding.dropdownItems.setVisibility(View.VISIBLE);
                }
            }
        });

        holder.binding.readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BlogView.class);
                intent.putExtra("title", title);
                intent.putExtra("content", content);
                intent.putExtra("author", author);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return blogModels.size();
    }

    public class BlogViewHolder extends RecyclerView.ViewHolder {

        BlogRecyclerBinding binding;

        public BlogViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = BlogRecyclerBinding.bind(itemView);
        }
    }
}
