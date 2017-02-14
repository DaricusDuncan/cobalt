package compiler.parser.primitives

import compiler.block.Block
import compiler.block.primitives.CharacterBlock
import compiler.parser.Parser
import compiler.tokenizer.Tokenizer

class CharacterParser extends Parser[CharacterBlock] {

  def shouldParse(line: String): Boolean = line.matches("(val|var)[ ]+[a-zA-Z][a-zA-Z0-9]*[ ]*:[ ]*char[ ]*[=][ ]*'[a-zA-Z0-9]'[ ]*")

  def parse(superBlock: Block, tokenizer: Tokenizer): CharacterBlock = {
    val declaration: Boolean = tokenizer.nextToken.token == "val" // "val" or "var"
    val name: String = tokenizer.nextToken.token //get name
    tokenizer.nextToken // skip ":"
    tokenizer.nextToken // skip "char"
    tokenizer.nextToken // skip "="
    val value: String = tokenizer.nextToken.token
    return new CharacterBlock(superBlock, declaration,name, value)
  }
}
