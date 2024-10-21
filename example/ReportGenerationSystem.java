// Abstract ReportGenerator Class
abstract class ReportGenerator {
    public final void generateReport() {
        formatHeader();
        formatBody();
        formatFooter();
    }

    protected abstract void formatHeader();
    protected abstract void formatBody();
    protected abstract void formatFooter();
}

// PDFReportGenerator Class
class PDFReportGenerator extends ReportGenerator {
    protected void formatHeader() {
        System.out.println("PDF Header");
    }

    protected void formatBody() {
        System.out.println("PDF Body");
    }

    protected void formatFooter() {
        System.out.println("PDF Footer");
    }
}

// Main Class
public class ReportGenerationSystem {
    public static void main(String[] args) {
        ReportGenerator pdfReport = new PDFReportGenerator();
        pdfReport.generateReport();
    }
}
