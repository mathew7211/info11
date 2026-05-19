from sympy import *


with open("output.txt", "r", encoding="utf-8") as f:
    output = f.read()

expr = sympify(output)

print(expr)
print()
print(expr.evalf())

parts = expr.as_ordered_terms()

simplified = []
for p in parts:
    simplified.append(sqrtdenest(p))

expr = Add(*simplified)

print(expr)

