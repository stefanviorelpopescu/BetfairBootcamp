package week05.observer;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SocialMediaProfile
{
    private final String name;

    List<SocialMediaProfile> followers = new ArrayList<>();

    public SocialMediaProfile(String name)
    {
        this.name = name;
    }

    public void follow(SocialMediaProfile profileToFollow) {
        profileToFollow.getFollowers().add(this);
    }

    public void unfollow(SocialMediaProfile profileToUnfollow) {
        profileToUnfollow.getFollowers().remove(this);
    }

    public void postMessage(String message) {
        for (SocialMediaProfile follower : followers)
        {
            follower.notify(this, message);
        }
    }

    public void notify(SocialMediaProfile source, String message) {
        System.out.println("NotificationReceiverd for: " + getName());
        System.out.println(source.getName() + " posted: " + message + "\n");
    }
}
