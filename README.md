# exempleComplexLambda
Exemple de Lambda JAVA 8 avec des types complexes :

Les lambdas servent à créer une liste d'objet "à plat" à partir d'une structure complexe sur laquelle il faut faire des opérations.

Une quittance a plusieurs opérations : la liaison entre Operation et Quittance n'est disponible que dans Operation (une opération contient une seule quittance).

Dans la représentation "à plat" on veut créer un objet Primes/Commission qui contient les infos d'une quittance, et l'addition de ses opérations réparties selon crédit/débit.
