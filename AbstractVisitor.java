import ast.*;

public abstract class AbstractVisitor<ReturnType, ArgType> {
    public abstract Void visit(Program p, Void fd); 

    public abstract Void visit(Block b, Void fc);

    public abstract Void visit(Variables v, Void fn);

    public abstract Void visit(VariableDeclaration vd , Void fh);

    public abstract Void visit(Procedures p, Void gh);

    public abstract Void visit(ProcedureDeclaration pd, Void mh);

    public abstract Void visit(FormalParameters fp, Void gt);

    public abstract Void visit(Statement s, Void gr);

    public abstract Void visit(AssignmentStatement as, Void ty);

    public abstract Void visit(CallStatement cs, Void gb);

    public abstract Void visit(ActualParameters ap, Void er);

    public abstract Void visit(CompoundStatement cs, Void dr);
  
    public abstract Void visit(IfStatement is, Void aq);

    public abstract Void visit(WhileStatement ws, Void el);

    public abstract Void visit(Condition c, Void sa);

    public abstract Void visit(Expression e, Void lk);

    public abstract Void visit(Term t, Void fg);

    public abstract Void visit(Factor f, Void ez);

    public abstract Void visit(ParenthesisFactor pf, Void fp);
}
