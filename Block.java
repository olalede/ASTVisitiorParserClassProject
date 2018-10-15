import ast.*;

public class Block extends AbstractNode 
{
    public Variables vNode = new Variables();
    public Procedures pNode = new Procedures();
    public Statement sNode = new Statement();

    public void setVariables(Variables v)
    {
        vNode = v;
    }
    
    public Variables getVariables()
    {
        return vNode;
    }

    public void setProcedures(Procedures p)
    {
        pNode = p;
    }
    
    public Procedures getProcedures()
    {
        return pNode;
    }

    public void setStatement(Statement s)
    {
        sNode = s;
    }
    
    public Statement getStatement()
    {
        return sNode;
    }

    public <RetType,ArgType> RetType accept(final AbstractVisitor<RetType, ArgType> v, final ArgType arg) 
    {
        v.visit(this, null);
        return null;
    }
}