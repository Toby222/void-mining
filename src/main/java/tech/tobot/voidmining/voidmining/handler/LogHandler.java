package tech.tobot.voidmining.voidmining.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import tech.tobot.voidmining.voidmining.VoidMining;

public class LogHandler {
  public static final Marker INTERNAL = MarkerManager.getMarker("INTERNAL");
  public              String name;
  
  public LogHandler(String name) {
    this.name = name;
  }
  
  public void debug(String msg) {
    debug(INTERNAL, msg);
  }
  
  public void debug(Marker marker, String msg) {
        if(VoidMining.DEBUG) {
      info(marker, msg);
    }
    else {
      getLogger().debug(marker, msg);
    }
  }
  
  public void info(String msg) {
    info(INTERNAL, msg);
  }
  
  public void info(Marker marker, String msg) {
    getLogger().info(marker, msg);
  }
  
  public void warn(String msg) {
    warn(INTERNAL, msg);
  }
  
  public void warn(Marker marker, String msg) {
    getLogger().warn(marker, msg);
  }
  
  public void error(String msg) {
    error(INTERNAL, msg);
  }
  
  public void error(Marker marker, String msg) {
    getLogger().error(marker, msg);
  }
  
  public Logger getLogger() {
    return LogManager.getLogger(this.name);
  }
}