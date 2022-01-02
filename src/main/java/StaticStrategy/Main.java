package StaticStrategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MarkdownStrategy markdownStrategy = new MarkdownStrategy();
        HTMLStrategy htmlStrategy = new HTMLStrategy();

        TextProcessor tp = new TextProcessor(markdownStrategy);
        tp.appendList(new String[]{"apple", "banana", "cherry"});
        System.out.println(tp);

        tp.clear();

        TextProcessor tp2 = new TextProcessor(htmlStrategy);
        tp2.appendList(new String[]{"apple", "banana", "cherry"});
        System.out.println(tp2);
    }
}

interface IListStrategy {
    void start(StringBuilder sb);
    void end(StringBuilder sb);
    void addListItem(StringBuilder sb, String item);
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
    private final IListStrategy listStrategy;

    TextProcessor(IListStrategy listStrategy) {
        this.listStrategy = listStrategy;
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