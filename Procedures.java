import ast.*;

public class Procedures extends AbstractNode 
{
    public ProcedureDeclaration pdNode = new ProcedureDeclaration();

    public void setProcedureDeclaration(ProcedureDeclaration pd)
    {
        pdNode = pd;
    }
    
    public ProcedureDeclaration getProcedureDeclaration()
    {
        return pdNode;
    }

    public <RetType,ArgType> RetType accept(final AbstractVisitor<RetType, ArgType> v, final ArgType arg) 
    {
        v.visit(this, null);
        return null;
    }
}