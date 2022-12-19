package com.example.datastructure.tree.print;

import java.util.ArrayList;
import java.util.List;

public class TreePrinter {

    public interface PrintableTree {
        PrintableTree getLeft();

        PrintableTree getRight();

        String getText();
    }

    public static String getDisplayTree(PrintableTree root) {

        StringBuilder sb = new StringBuilder();
        List<List<String>> lines = new ArrayList<>();
        List<PrintableTree> level = new ArrayList<>();
        List<PrintableTree> next = new ArrayList<>();

        level.add(root);
        int nn = 1;
        int widest = 0;

        while (nn != 0) {
            nn = 0;
            List<String> line = new ArrayList<>();
            for (PrintableTree n : level) {
                if (n == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.getText();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getLeft());
                    next.add(n.getRight());

                    if (n.getLeft() != null) nn++;
                    if (n.getRight() != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<PrintableTree> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;
            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '#' : '#';
                        } else {
                            if (line.get(j) != null) c = '#';
                        }
                    }
                    sb.append(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        sb.append(" ".repeat(Math.max(0, perpiece - 1)));
                    } else {
                        sb.append((j % 2 == 0 ? " " : "#").repeat(Math.max(0, hpw)));
                        sb.append(j % 2 == 0 ? "#" : "#");
                        sb.append((j % 2 == 0 ? "#" : " ").repeat(Math.max(0, hpw)));
                    }
                }
                sb.append('\n');
            }
            for (String f : line) {
                if (f == null) f = "";
                float a = perpiece / 2f - f.length() / 2f;
                int gap1 = (int) Math.ceil(a);
                int gap2 = (int) Math.floor(a);

                sb.append(" ".repeat(Math.max(0, gap1)));
                sb.append(f);
                sb.append(" ".repeat(Math.max(0, gap2)));
            }
            sb.append('\n');

            perpiece /= 2;
        }
        return sb.toString();
    }
}
