# datastructures
Collection of some must know data structures

# Asymptotic Notations

Big Oh : upper bound
f(n) = n2 + 2n + 3
=> f(n) <= n2 + 2n2 + 3n2 <= 6n2 [C.F(n)]
=> **O(n2)**

Big Omega : lower bound
f(n) = n2 + 2n + 3
=> f(n) >= n2 [C.F(n)]
=> **Ω(n2)**

Big Theta : upper as well as lower bound
f(n) = n2 + 2n + 3
=> n2 <= f(n) <= 6n2 [C.F(n)]
=> **Θ(n2)**

* Big Omega tells us the lower bound of the runtime of a function, and Big O tells us the upper bound. Often times, they are different and we can’t put a guarantee on the runtime - it will vary between the two bounds and the inputs. But what happens when they’re the same? Then we can give a theta (Θ) bound - our function will run in that time, no matter what input we give it. In general, we always want to give a theta bound if possible because it is the most accurate and tightest bound. If we can’t give a theta bound, the next best thing is the tightest O bound possible.

