package cn.bytengine.guider.scripts;

import cn.bytengine.guider.scripts.antlr.RpmnsLexer;
import cn.bytengine.guider.scripts.antlr.RpmnsParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) {
        RpmnsLexer lexer = new RpmnsLexer(CharStreams.fromString("Hello world"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RpmnsParser parser = new RpmnsParser(tokens);
        ParseTree tree = parser.s();
        System.out.println(tree.toStringTree(parser));
    }
}
