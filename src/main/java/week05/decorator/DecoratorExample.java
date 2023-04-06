package week05.decorator;

public class DecoratorExample
{
    public static void main(String[] args)
    {
        //initial code
        AccountStatementProvider accountStatementProvider = new AccountStatementProviderImpl();
        System.out.println(accountStatementProvider.getAccountStatement(5));

        //after adding decorator
        AccountStatementProviderDecorator accountStatementProviderDecorator = new AccountStatementProviderDecoratorImpl(accountStatementProvider);
        System.out.println(accountStatementProviderDecorator.getAccountStatement(5));
        System.out.println(accountStatementProviderDecorator.getCsvAccountStatement(5));
        System.out.println(accountStatementProviderDecorator.getXmlAccountStatement(5));
    }
}
