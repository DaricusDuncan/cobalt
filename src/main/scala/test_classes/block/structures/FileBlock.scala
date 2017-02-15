package test_classes.block.structures

import test_classes.block.Block

/**
  * Represents the whole file.
  */
class FileBlock(name: String) extends Block(null, true, false) {

  def init() {}

  def getName: String = name

  def getValue: String = null

  def getType: String = null

  def getOpeningCode: String = ""

  def getClosingCode: String = ""

  override def toString: String = "file: " + name
}