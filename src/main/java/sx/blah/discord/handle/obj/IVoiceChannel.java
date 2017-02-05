package sx.blah.discord.handle.obj;

import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.util.List;

/**
 * Represents a voice channel.
 */
public interface IVoiceChannel extends IChannel {
	/**
	 * This gets the maximum amount of users allowed in this voice channel.
	 *
	 * @return The maximum amount of users allowed (or 0 if there is not set limit)
	 */
	int getUserLimit();

	/**
	 * Gets the current bitrate of this voice channel.
	 *
	 * @return The bitrate of this voice channel in bits.
     */
	int getBitrate();

	/**
	 * Edits all properties of this voice channel.
	 *
	 * @param name The new name of the channel.
	 * @param position The new position of the channel.
	 * @param bitrate The new bitrate of the channel (in bits).
	 * @param userLimit The new user limit of the channel.
	 *
	 * @throws MissingPermissionsException
	 * @throws DiscordException
	 * @throws RateLimitException
	 */
	void edit(String name, int position, int bitrate, int userLimit) throws DiscordException, RateLimitException, MissingPermissionsException;

	/**
	 * Changes the bitrate of the channel
	 *
	 * @param bitrate The new bitrate of the channel (in bits).
	 * @throws RateLimitException
	 * @throws DiscordException
	 * @throws MissingPermissionsException
	 */
	void changeBitrate(int bitrate) throws DiscordException, RateLimitException, MissingPermissionsException;

	/**
	 * Changes the user limit of the channel
	 *
	 * @param limit The new user limit of the channel.
	 * @throws RateLimitException
	 * @throws DiscordException
	 * @throws MissingPermissionsException
	 */
	void changeUserLimit(int limit) throws DiscordException, RateLimitException, MissingPermissionsException;

	/**
	 * Makes the bot user join this voice channel.
	 *
	 * @throws MissingPermissionsException
	 */
	void join() throws MissingPermissionsException;

	/**
	 * Makes the bot user leave this voice channel.
	 */
	void leave();

	/**
	 * Checks if this voice channel is connected to by our user.
	 *
	 * @return True if connected, false if otherwise.
	 */
	boolean isConnected();

	/**
	 * {@inheritDoc}
	 */
	IVoiceChannel copy();

	/**
	 * This collects all users connected to this voice channel and returns them in a list.
	 *
	 * @return The connected users.
	 */
	List<IUser> getConnectedUsers();
}