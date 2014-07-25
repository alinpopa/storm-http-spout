package storm

import java.util

import backtype.storm.spout.SpoutOutputCollector
import backtype.storm.task.TopologyContext
import backtype.storm.topology.OutputFieldsDeclarer
import backtype.storm.topology.base.BaseRichSpout
import backtype.storm.tuple.{Values, Fields}

class SimpleSampleSpout extends BaseRichSpout {
  private var collector: SpoutOutputCollector = null

  override def declareOutputFields(declarer: OutputFieldsDeclarer): Unit = {
    declarer.declare(new Fields(""))
  }

  override def nextTuple(): Unit = {
    collector.emit(new Values("Some Amazing Value"))
  }

  override def open(conf: util.Map[_, _], context: TopologyContext, collector: SpoutOutputCollector): Unit = {
    this.collector = collector
  }
}
