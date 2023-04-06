package week05.decorator;

import javax.xml.crypto.dsig.XMLObject;

public interface AccountStatementProviderDecorator extends AccountStatementProvider
{
    String getCsvAccountStatement(int daysOld);
    XMLObject getXmlAccountStatement(int daysOld);
}
