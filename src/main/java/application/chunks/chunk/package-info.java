/**
 * Single chunk.
 * A chunk contains n * n blocks.
 * The purpose of having this concept is to help us effectively generate the map.
 * As player moves, new blocks will be generated dynamically.
 * In other words, the player will trigger the world generation.
 * The questions is, how many blocks should we generate?
 * Instead of saying "we will create n blocks around the player", we will say "we will create n chunks around the player."
 * Just like we have different unit of scale such as gram, kilogram, ton, etc., players can communicate each other in terms of chunk instead of block.
 */
package application.chunks.chunk;