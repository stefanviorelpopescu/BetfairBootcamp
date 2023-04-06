package week05.observer;

public class ObserverExample
{
    public static void main(String[] args)
    {
        SocialMediaProfile ion = new SocialMediaProfile("Ion");
        SocialMediaProfile maria = new SocialMediaProfile("Maria");
        SocialMediaProfile apache = new SocialMediaProfile("Apache");
        SocialMediaProfile grivei = new SocialMediaProfile("Grivei");

        ion.follow(maria);
        ion.follow(apache);
        grivei.follow(ion);
        apache.follow(grivei);
        apache.follow(maria);
        apache.follow(ion);

        maria.postMessage("Buna tuturor!");
        ion.postMessage("Aoleu!");

        grivei.unfollow(ion);

        ion.postMessage("Hai noroc!");
    }
}
