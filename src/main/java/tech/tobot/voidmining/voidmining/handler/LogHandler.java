package tech.tobot.voidmining.voidmining.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import tech.tobot.voidmining.voidmining.VoidMining;

public class LogHandler {
  public static final Marker INTERNAL = MarkerManager.getMarker("INTERNAL");
  public              String name;
  
  public LogHandler(final String name) {
    this.name = name;
  }
  
  public void debug(final String msg) {
    debug(LogHandler.INTERNAL, msg);
  }
  
  public void debug(final Marker marker, final String msg) {
    if(VoidMining.DEBUG) {
      info(marker, msg);
    }
    else {
      getLogger().debug(marker, msg);
    }
  }
  
  public void info(final String msg) {
    info(LogHandler.INTERNAL, msg);
  }
  
  public void info(final Marker marker, final String msg) {
    getLogger().info(marker, msg);
  }
  
  public void warn(final String msg) {
    warn(LogHandler.INTERNAL, msg);
  }
  
  public void warn(final Marker marker, final String msg) {
    getLogger().warn(marker, msg);
  }
  
  public void error(final String msg) {
    error(LogHandler.INTERNAL, msg);
  }
  
  public void error(final Marker marker, final String msg) {
    getLogger().error(marker, msg);
  }
  
  public Logger getLogger() {
    return LogManager.getLogger(name);
  }
}