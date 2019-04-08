/**
 * Collection of chunks.
 * The purpose of this concept is to help us effectively generate chunks.
 * World generation is not an easy task.
 * We need to listen to the player movement, run the random block generation algorithm, and etc.
 * Long story short, the task of world generation is big enough to make this concept.
 * Since the world is essentially responsible for generating the chunks from the player's perspective, this concept should be used in the world object internally.
 */
package application.chunks;