package storm

import backtype.storm.{LocalCluster, Config}
import backtype.storm.topology.TopologyBuilder

object SampleApp {
  def main(args: Array[String]): Unit = {
    val builder = new TopologyBuilder()
    builder.setSpout("Spouty", new SimpleSampleSpout())
    builder.setBolt("print", new PrinterBolt(), 4).shuffleGrouping("Spouty")
    new LocalCluster().submitTopology("test", new Config(), builder.createTopology())
  }
}
