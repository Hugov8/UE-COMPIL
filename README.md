# Projet Compilation

PCF Noir implémenté

Le traitement de FixFun se fait dans le transformer pour ne pas à avoir à modifier le backend, tout comme le LetPlus


## Exemple non polymorphisme
```
let f = (fun x->x) in ifz (f 0) then (f (fun x->x)) else (f (fun x->x))
```
f devient un INT->INT après évaluation dans le ifz (f 0) et l'argument de f dans le then et le else est du mauvais type. Cela montre que le polymorphisme n'est pas implémenté