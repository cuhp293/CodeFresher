void main() {
  //=================================================================
  // VARIABLES: You can store different types of info into variables
  String name = "Mitch Koko";
  int age = 27;
  double pi = 3.14159;
  bool isBeginner = true;

  /* BASIC MATH OPERATORS: + - * / %
    1 + 1 -> 2, add
    4 - 1 -> 3, subtract
    2 * 3 -> 6, multiply
    8 / 4 -> 2, divide
    9 % 4 -> 1, remainder

    5++ -> 6, increment by 1
    5-- -> 4, decrement by 1
   */

  /* COMPARISON OPERATORS:
    5 == 5 -> true,  EQUAL TO
    2 != 3 -> true,  NOT EQUAL TO
    3 > 2  -> true,  GREATER THAN
    3 < 2  -> false, LESS THAN
    5 >= 5 -> true,  GREATER OR EQUAL TO
    3 <= 5 -> true,  LESS OR EQUAL TO
   */

  /* LOGICAL OPERATORS:
    &&, AND operator, returns true if both sides are true
    ||, OR  operator, returns true if at least one side is true
    !,  NOT operator, returns the opposite value
   */

  //=================================================================
  /* CONTROL FLOW
    break    -> break out of loop           (1 2 3 4)
    continue -> skip this current iteration (1 2 3 5 6)

    if (condition) {}
    else {}
    else if (condition) {}

    switch (expression) {
      case value:
        break;
      default:
    }

    for ( initialization; condition; iteration ) {}

    while (condition) {} -> don't know how many times to loop
   */

  //=================================================================
  /* FUNCTIONS/METHODS
    - basic function:            greet();
    - function with parameters:  greetPerson(name, age);
    - function with return type: var sum = add(a, b);
   */

  //=================================================================
  /* DATA STRUCTURES
    LIST: ordered collections of elements, can have duplicates.
    List numbers = [1, 2, 3];     OR      List<int> numbers = [1, 2, 3];
    - numbers[0] -> 1
    - numbers.length

    ------------------------------------------------------------------
    SET: unordered collections of unique elements
    Set<String> uniqueNames = {"Mitch", "Sharon", "Vince"};

    ------------------------------------------------------------------
    MAP: stored as key-value pairs
    Map user = {
      'name': "Mitch Koko",
      'age': 27,
      'height': 180,
    };
    - user['name'] -> "Mitch Koko"
   */
}