package np.com.aayushgautam.believe.ChatWithSomeone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import np.com.aayushgautam.believe.R;
import np.com.aayushgautam.believe.databinding.ItemReceiveBinding;
import np.com.aayushgautam.believe.databinding.ItemSendBinding;

public class MessagesAdapter  extends RecyclerView.Adapter {

    Context context;
    ArrayList<MessageModel> messages;

    final int ITEM_SENT = 1;
    final int ITEM_RECEIVED = 2;

    public MessagesAdapter(Context context, ArrayList<MessageModel> messages) {
        this.context = context;
        this.messages = messages;

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ITEM_SENT){
            View view= LayoutInflater.from(context).inflate(R.layout.item_send,parent,false);
            return new SendViewHolder(view);
        }else {
            View view= LayoutInflater.from(context).inflate(R.layout.item_receive,parent,false);
            return new ReceiverViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        MessageModel message = messages.get(position);
        if (message.isSent()) {
            return ITEM_SENT;
        } else return ITEM_RECEIVED;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageModel message = messages.get(position);

        if (holder.getClass()==SendViewHolder.class){
            SendViewHolder viewHolder = (SendViewHolder)holder;
            viewHolder.binding.message.setText(message.getMessage());

        }else {
            ReceiverViewHolder viewHolder = (ReceiverViewHolder)holder;
            viewHolder.binding.message.setText(message.getMessage());

        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class SendViewHolder extends RecyclerView.ViewHolder {

        ItemSendBinding binding;

        public SendViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemSendBinding.bind(itemView);
        }
    }

    public class ReceiverViewHolder extends RecyclerView.ViewHolder {

        ItemReceiveBinding binding;

        public ReceiverViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemReceiveBinding.bind(itemView);
        }
    }
}
