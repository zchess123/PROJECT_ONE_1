package main.java;

import java.io.IOException;

/** Driver class for the Talk socket application. */
public class Talk {

  /**
   * The program behaves as a client with the specified client connection.
   * @param client the client interface to use for socket communication
   * @return {@code false} if the host is not available
   * @throws never should return {@code false} rather than throwing an exception
   */
  protected boolean clientMode(BasicTalkInterface client) {
    // TODO: complete clientMode
    return false;
  }

  /**
   * The program behaves as a server with the specified server.
   * @param server the server interface to use for socket communication
   * @return {@code false} if the port is not available
   * @throws never should return {@code false} rather than throwing an exception
   */
  protected boolean serverMode(BasicTalkInterface server) {
    // TODO: complete serverMode
    return false;
  }

  /**
   * The program enters auto mode and behaves as a client attempting to connect to the specified
   * host on the specified port. If the host is not available, the program should behave as a
   * server listening for connections on the specified port.
   * @param hostname the host to connect to
   * @param portnumber the port to connect to or listen on
   * @return {@code false} if the host and port are both unavailable
   * @throws never should return {@code false} rather than throwing an exception
   */
  public boolean autoMode(String hostname, int portnumber) {
    // TODO: complete autoMode - should call clientMode and serverMode
    return false;
  }

  /**
   * The program behaves as a client connecting to the specified host on the specified port.
   * @param hostname the host to connect to
   * @param portnumber the port to connect to
   * @return {@code false} if the host is not available
   * @throws never should return {@code false} rather than throwing an exception
   */
  public boolean clientMode(String hostname, int portnumber) {
    try {
      return this.clientMode(new TalkClient(hostname, portnumber));
    } catch (IOException e) {
      return false;
    }
  }

  /**
   * Should print your name and instructions on how to use the talk program. Instructions must
   * at least include the line "Talk [-a | –h | -s] [hostname | IPaddress] [–p portnumber]"
   */
  public void helpMode() {
    // TODO: complete helpMode
  }

  /**
   * The program behaves as a server listening for connections on the specified port.
   * @param portnumber the port to listen for connections on
   * @return {@code false} if the port is unavailable
   * @throws never should return {@code false} rather than throwing an exception
   */
  public boolean serverMode(int portnumber) {
    try {
      return this.serverMode(new TalkServer(portnumber));
    } catch (IOException e) {
      return false;
    }
  }

  /**
   * Parses the specified args and executes the talk program in its intended mode.
   * @param args the CLI args
   * @throws never should return {@code false} rather than throwing an exception
   */
  public boolean start(String[] args) {
    // TODO: complete start - should call autoMode, clientMode, helpMode, and serverMode
    return false;
  }

  public static void main(String[] args) {
    System.exit(new Talk().start(args) ? 0 : 1);
  }
}
