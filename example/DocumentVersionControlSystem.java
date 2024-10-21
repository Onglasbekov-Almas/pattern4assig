// Memento Class
class DocumentVersion {
    private String content;

    public DocumentVersion(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// Document Class
class Document {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public DocumentVersion saveVersion() {
        return new DocumentVersion(content);
    }

    public void restoreVersion(DocumentVersion version) {
        content = version.getContent();
    }
}

// VersionControl Class
class VersionControl {
    private List<DocumentVersion> versions = new ArrayList<>();

    public void save(Document document) {
        versions.add(document.saveVersion());
    }

    public DocumentVersion getVersion(int index) {
        return versions.get(index);
    }
}

// Main Class
public class DocumentVersionControlSystem {
    public static void main(String[] args) {
        Document doc = new Document();
        VersionControl vc = new VersionControl();

        doc.setContent("Version 1");
        vc.save(doc);

        doc.setContent("Version 2");
        vc.save(doc);

        System.out.println("Current content: " + doc.getContent());

        doc.restoreVersion(vc.getVersion(0));
        System.out.println("Restored content: " + doc.getContent());
    }
}
