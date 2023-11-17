package cn.bytengine.guider.scripts;

import cn.bytengine.guider.scripts.antlr.RpmnsBaseVisitor;
import cn.bytengine.guider.scripts.antlr.RpmnsLexer;
import cn.bytengine.guider.scripts.antlr.RpmnsParser;
import cn.hutool.core.io.FileUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) {
        byte[] rpmnProject = FileUtil.readBytes("project.rpmn");
        RpmnsLexer lexer = new RpmnsLexer(CharStreams.fromString(new String(rpmnProject)));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        final RpmnsParser parser = new RpmnsParser(tokens);
        ParseTree tree = parser.project();
        tree.accept(new RpmnsBaseVisitor<Object>() {
            @Override
            public Object visitProject(RpmnsParser.ProjectContext ctx) {
                System.out.println(ctx.getChildCount());
                return super.visitProject(ctx);
            }
        });
        System.out.println(tree.toStringTree());
    }
}
