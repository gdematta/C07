Authors: Gabe De Matte, Spencer Groth

Implements Drawable (no interaction and not actually a game piece, so doesn't extend GamePiece)
Coral- Coral does not move and does not interact with the player

Extends GamePiece, implements Moveable
Shark- Moves 2 spaces at a time left to right across the board, jumps over pieces. 
Fish- Moves randomly across the board, jumps over pieces. Does not interact.

Extends GamePiece with various InteractionResult
WARPF/WARPBACK/NONE - Whirlpool // Whirlpools will teleport the player to the other whirlpool, which are a always 12 spaces apart. There can only be 2 of them on the map
HIT/NONE - Jellyfish // Jellyfish will sting the player for 1 hit if they are on top or beside it after 1 turn has passed
KILL/NONE - Sea Mine // Sea Mines will kill a player that lands on top of it
HIT/NONE - Shark // Sharks will damage the player if they are on top of or beside it
ADVANCE/NONE - Treasure Chest // Treasure Chests advance the player to the next level if they land on it
GET_POINT/NONE - Coin // Coins give a point if the player lands on it 
