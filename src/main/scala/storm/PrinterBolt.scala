package storm

import backtype.storm.topology.{BasicOutputCollector, OutputFieldsDeclarer}
import backtype.storm.topology.base.BaseBasicBolt
import backtype.storm.tuple.Tuple

class PrinterBolt extends BaseBasicBolt{
  override def execute(input: Tuple, collector: BasicOutputCollector): Unit = {
    println(input)
  }

  override def declareOutputFields(declarer: OutputFieldsDeclarer): Unit = {

  }
}
