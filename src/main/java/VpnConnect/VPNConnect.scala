package VpnConnect

import com.jcraft.jsch._

/**
 * Created by rohanp on 4/27/17.
 */
class VPNConnect {
  def connectVpn() : Unit = {
    val ftpHost = "nb-perf-puppetmaster.eastus2.cloudapp.azure.com"
    val ftpPort = 22
    val user = "rpandhare"
    val privateKey = "/home/rohanp/keys/RohanPandharePrivateKey.ppk"
    val privatekeyPassword = "M3k$E9&c27"
    val jsch = new JSch

    try{
      jsch.addIdentity(privateKey,privatekeyPassword)
      println("Added private key in session!!!")
      val session = jsch.getSession(user, ftpHost, ftpPort)
      println("created new session object!!!")
      session.setPassword(privatekeyPassword)
      println("added password to session!!!")
      session.setConfig("StringHostKeyChecking","no")
      println("setting config to session...")
      session.connect
      println("session connected....")

      /*jsch.addIdentity(privateKey)
      println("Added private key in session!!!")
      val session = jsch.getSession(user, ftpHost, ftpPort)
      println("created new session object!!!")
      session.setConfig("StringHostKeyChecking","no")
      println("setting config to session...")
      session.connect
      println("session connected....")*/

    }catch {
      case ex => {
        println("GotException =>" + ex)
      }
    }
  }
}

object VPNConnect{
  def main(args : Array[String]) : Unit = {
    val a = new VPNConnect()
    a.connectVpn()
  }
}