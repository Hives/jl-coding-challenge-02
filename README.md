# John Lewis Coding Challenge 02

Write a function that takes a string representing a price label and validate the
reductions. E.g.
- "Was £8, then £9, now £6" validates to "Was £9, now £6".

[Full details](https://coding-challenges.jl-engineering.net/challenges/challenge-2/)

## Thoughts, etc.

I used a functional approach - no mutable variables or types. I used a tail
recursive function to achieve this. I think you could probably do it using
`.fold()` - maybe I'll come back and do that later.

My `.getPrices()` method is an extension function on `String`. Is that a good
idea? Should I limit it to a `Label` class? Or maybe it doesn't matter because
it's private so it can't be used in any other context, and I know it's always
going to be called on a sensible receiver?
