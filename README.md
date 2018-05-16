# SortingHat - A Neural Network Aproach #

This Artificial Neural Network was developed in the IntelliJ IDE 2018.1 and using Java 1.9 for recognise, based on inputs, the specialization fields at ESPM Information System (TECH) students.

-----------------------------------------------

## Inputs ##

The input layer has __15__ neurons and accept this following values:

* 1.    Você possui facilidade com as disciplinas de desenvolvimento? (Matérias que, de algum modo, envolvam algoritmos, lógica e programação) 
* 2.    Você possui facilidade com as disciplinas de gestão?
* 3.    Você possui facilidade com as disciplinas quantitativas?
* 4.    Você possui facilidade com as disciplinas de banco de dados?
* 5.    Você possui facilidade com as disciplinas de design? (Matérias que, de algum modo, envolvam frontend, UX ou animação 3D)   
* 6.    Você gosta das disciplinas de desenvolvimento? (Matérias que, de algum modo, envolvam algoritmos, lógica e programação)
* 7.    Você gosta das disciplinas de gestão?
* 8.    Você gosta das disciplinas quantitativas?
* 9.    Você gosta das disciplinas de banco de dados?
* 10.   Você gosta das disciplinas de design? (Matérias que, de algum modo, envolvam frontend, UX ou animação 3D)
* 11.   Você possui facilidade com raciocínio lógico?
* 12.   Você possui interesse na resolução de problemas por meio da modelagem ou desenvolvimento de sistemas?
* 13.   Você possui interesse em entender o funcionamento das mecânicas de jogos?
* 14.   Você possui interesse na modelagem ou desenvolvimento de jogos/animações?
* 15.   Você possui interesse na resolução de problemas, baseando-se na extração, manipulação e análise de informações? 

_Obs: You can find the input values at the data folder._

----------------------------

## Structure ##

You can find at the packages __paes.training.c1__ or __paes.training.c2__, respectively, RNAs with one and two hidden layers. This files contains the propagation and the backpropagation algorithm (training algorithm). At __paes.test.c1__ or __paes.test.c2__, you can find the responsible classes for testing assertiveness rate.

### Variables ###

* int n = 3 - _This variable is responsible for the number of neurons in the hidden layer;_
* int minValue = 0 - _This variable is responsible for control the input's matrix;_
* int age = 1 - _This variable is responsible for count the number of ages;_

_Obs: 1 age is equals 84 iterations._

### Methods ###

#### Propagation ####
* ponderationL1();
* activationL1();
* ponderationL2();
* activationL2();
* ponderationL3() _Obs: Only in c2 classes_;
* activationL3() _Obs: Only in c2 classes_;

#### Error Calculation ####
* errorCalculation();

#### BackPropagation ####
* gradientCalculationL3() _Obs: Only in c2 classes_;
* gradientCalculationL2();
* gradientCalculationL1();
* weightsUpdateL3() _Obs: Only in c2 classes_;
* weightsUpdateL2();
* weightsUpdateL1();
---------------------------------------

## Outputs ##

The output layer has __3__ neurons. The following combination represents one of the multiples outputs, that can be printed by the RNA.

* _Business Intelligence - BI_: 0 0 1;
* _Mobile Development - DEV_: 0 1 0;
* _Games_: 1 0 0';
* _Unidentified Spec Field detected!_: 0 0 0;
* _Unidentified Spec Field detected!_: 1 1 1.

----------------------------

## Results - c1 (one hidden layer)

#### Sigmoid Function ####

* __2 Neurons:__
  * _NaN_;
 
* __3 Neurons:__
  * 93.33 % Success (28/30 successes);
 
* __8 Neurons:__
  * 93.33 % Success (28/30 successes);

#### Hyperbolic Tangent (tanh) ####

* __2 Neurons:__
  * _NaN_;
 
* __3 Neurons:__
  * 3.00 % Success (1/30 successes);
 
* __8 Neurons:__
  * 13.33 % Success (4/30 successes);

#### ReLU (Rectified linear unit) ####

* __2 Neurons:__
  * _Time Exception_;
 
* __3 Neurons:__
  * _Time Exception_;
 
* __8 Neurons:__
  * _Time Exception_;
  
 ___Obs:___ 
 * _NaN: Incapacibility of achieving a Numeric Value. Probably because the flutuant pointer has exploded_;
 * _Time Exception: Incapacibility of converging in a polynomial time, or, at least, the incapacibility of converging in a time next to the sigmoid or tanh functions times_.
---------------------------------------

## Results - c2 (two hidden layers)

#### Sigmoid Function ####

* __2 Neurons:__
  * _NaN_;
 
* __3 Neurons:__
  * _NaN_;
 
* __8 Neurons:__
  * 33.33 % Success (10/30 successes);

#### Hyperbolic Tangent (tanh) ####

* __2 Neurons:__
  * _Time Exception_;
 
* __3 Neurons:__
  * _Time Exception_;
 
* __8 Neurons:__
  * 0.00 % Success (0/30 successes);

#### ReLU (Rectified linear unit) ####

* __2 Neurons:__
  * _Time Exception_;
 
* __3 Neurons:__
  * _Time Exception_;
 
* __8 Neurons:__
  * _Time Exception_;
  
 ___Obs:___ 
 * _NaN: Incapacibility of achieving a Numeric Value. Probably because the flutuant pointer has exploded_;
 * _Time Exception: Incapacibility of converging in a polynomial time, or, at least, the incapacibility of converging in a time next to the sigmoid or tanh functions times_.
---------------------------------------

## References Links ##

__Activation Functions:__
* <https://en.wikipedia.org/wiki/Activation_function/>

__FACURE, Matheus:__
* <https://matheusfacure.github.io/2017/07/12/activ-func/>

__HAYKIN, Simon:__ 
* Neural Network. 3rd Edition. Artmed. 2008

__Rectifier Nonlinearities Improve Neural Network Acoustic Models__:
* <http://web.stanford.edu/~awni/papers/relu_hybrid_icml2013_final.pdf/>

__Sample repository:__
* <https://archive.ics.uci.edu/ml/datasets/iris/>

--------------------------------------------------
