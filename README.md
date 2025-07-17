# Judgement

This is a console-based Java implementation of **Judgement**, a classic multiplayer card game. The game is designed for 4 players: 3 computer players and 1 human player.

## Game Rules (Simplified)

- The game is played in 13 rounds (since there are 4 players in this implementation).
- Each round, the number of cards dealt to each player changes (e.g., 1 card in Round 1, 2 in Round 2, etc.).
- At the start of each round, each player predicts how many turns they may win, based on their own judgement of their dealt hand (see why it's called that?)
- A **trump suit** is selected for each round, cycling through: Spades → Diamonds → Clubs → Hearts → No Trump.
- Players play one card per turn.
- The highest card of the lead suit (the suit of the very first card played in that turn) wins the turn, unless a trump is played.
- If a trump card is played and no higher trump card follows, it wins the turn.
- After the round is over, each person's turns are counted
- If a player wins the exact number of turns they predicted, they win x10 points.
- If a player's prediction is lower or higher than the turns they actually won, 

## What works right now

- Turn-by-turn gameplay
- A very basic points system

## What does not work right now

- The judgement mechanic (yeah i know, im working on it okay). I would need to implement some kind of algorithm for it, clearly.
- Round by round points system
