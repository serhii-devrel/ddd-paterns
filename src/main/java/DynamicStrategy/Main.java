package DynamicStrategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TextProcessor tp = new TextProcessor();
        tp.setOutputFormat(OutputFormat.HTML);
        tp.appendList(new String[]{"apple", "banana", "cherry"});
        System.out.println(tp);

        tp.clear();

        tp.setOutputFormat(OutputFormat.Markdown);
        tp.appendList(new String[]{"apple", "banana", "cherry"});
        System.out.println(tp);
    }
}

interface IListStrategy {
    void start(StringBuilder sb);
    void end(StringBuilder sb);
    void addListItem(StringBuilder sb, String item);
}

enum OutputFormat {
    Markdown,
    HTML
}

class MarkdownStrategy implements IListStrategy {

    @Override
    public void start(StringBuilder sb) {}

    @Override
    public void end(StringBuilder sb) {}

    @Override
    public void addListItem(StringBuilder sb, String item) {
        sb.append(String.format(" * %s \n", item));
    }
}

class HTMLStrategy implements IListStrategy {

    @Override
    public void start(StringBuilder sb) {
        sb.append("<ul>");
    }

    @Override
    public void end(StringBuilder sb) {
        sb.append("</ul>");
    }

    @Override
    public void addListItem(StringBuilder sb, String item) {
        sb.append(String.format("\n  <li>%s</li>\n", item));
    }
}

class TextProcessor {
    private final StringBuilder sb = new StringBuilder();
    private IListStrategy listStrategy;

    public void setOutputFormat(OutputFormat format) {
        switch (format) {
            case HTML:
                listStrategy = new MarkdownStrategy();
                break;
            case Markdown:
                listStrategy = new HTMLStrategy();
                break;
        }
    }

    public void clear() {
        this.sb.setLength(0);
    }

    @Override
    public String toString() {
        return this.sb.toString();
    }

    public void appendList(String[] items) {
        listStrategy.start(this.sb);
        Arrays.stream(items).forEach(item -> listStrategy.addListItem(this.sb, item));
        listStrategy.end(this.sb);
    }
}