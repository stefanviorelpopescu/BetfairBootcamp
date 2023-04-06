package week05.decorator;

import javax.xml.crypto.dsig.XMLObject;

public class AccountStatementProviderDecoratorImpl implements AccountStatementProviderDecorator
{
    AccountStatementProvider accountStatementProvider;

    public AccountStatementProviderDecoratorImpl(AccountStatementProvider accountStatementProvider)
    {
        this.accountStatementProvider = accountStatementProvider;
    }

    @Override
    public String getCsvAccountStatement(int daysOld)
    {
        AccountStatement accountStatement = accountStatementProvider.getAccountStatement(daysOld);
        // code generating CSV file
        return accountStatement.toString();
    }

    @Override
    public XMLObject getXmlAccountStatement(int daysOld)
    {
        AccountStatement accountStatement = accountStatementProvider.getAccountStatement(daysOld);
        //code generating XML file
        return null;
    }

    @Override
    public AccountStatement getAccountStatement(int daysOld)
    {
        return accountStatementProvider.getAccountStatement(daysOld);
    }
}
