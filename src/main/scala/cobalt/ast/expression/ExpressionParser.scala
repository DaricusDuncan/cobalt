/*
 * Cobalt Programming Language Compiler
 * Copyright (C) 2017  Cobalt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package cobalt.ast.expression

import cobalt.ast.{Block, Parser}
import cobalt.tokenizer.Tokenizer

class ExpressionParser extends Parser[ExpressionBlock] {
  /**
    * A list of all regular stack
    *
    * @return
    */
  override val regex: String = "^([\\(\\)]*([0-9]+(([\\.][0-9]*)?([dDfFsSlLbB])?)|([a-zA-Z][a-zA-Z_]*))[ \\(\\)]*[\\+\\-\\*\\/][ \\(\\)]*)+([0-9]+(([\\.][0-9]*)?([dDfFsSlLbB])?)|([a-zA-Z][a-zA-Z_]*))[ \\(\\)]*"

  def parse(superBlock: Block, tokenizer: Tokenizer): ExpressionBlock = {


    new ExpressionBlock(superBlock, tokenizer)
  }
}
