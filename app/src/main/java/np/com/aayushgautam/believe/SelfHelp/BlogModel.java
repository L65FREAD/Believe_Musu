package np.com.aayushgautam.believe.SelfHelp;

public class BlogModel {
    private String title, author, content, preview;

    public BlogModel() {

    }

    public BlogModel(String title, String author, String content, String preview) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.preview = preview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
