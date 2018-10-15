import ast.*;

public class Variables extends AbstractNode 
{
    public VariableDeclaration vdNode = new VariableDeclaration();

    public void setVariableDeclaration(VariableDeclaration vd)
    {
        vdNode = vd;
    }
    
    public VariableDeclaration getVariableDeclaration()
    {
        return vdNode;
    }

    public <RetType,ArgType> RetType accept(final AbstractVisitor<RetType, ArgType> v, final ArgType arg) 
    {
        v.visit(this, null);
        return null;
    }
}