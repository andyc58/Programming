import random
import time  # https://docs.python.org/3/library/time.html

"""Rock Paper Scissors Lizard Spock is a twist on the game rock paper scissors where there are 
5 objects to choose from instead of the usual three. The game is based off of an episode of 
The Big Bang Theory that I watched recently. According to Sheldon Cooper, the outcomes are as follows: 
    *Scissors beats Paper, 
    *Paper beats Rock, 
    *Rock beats Lizard,
    *Lizard beats Spock,
    *Spock beats Scissors
    *Scissors beats Lizard
    *Lizard beats Paper
    *Paper beats Spock
    *Spock beats Rock
    *Rock beats Scissors """

# This function defines all possible outcomes of the game


def outcomes(p1_input, p2_input, p2_name):
    # Tie
    if p1_input == p2_input:
        return "It's a Tie!"

    # Scissors cuts Paper
    elif p1_input == "Scissors" and p2_input == "Paper":
        return "You win! {} cuts {}".format(p1_input, p2_input)
    elif p1_input == "Paper" and p2_input == "Scissors":
        return "{} wins! {} cuts {}".format(p2_name, p2_input, p1_input)

    # Paper covers rock
    elif p1_input == "Paper" and p2_input == "Rock":
        return "You win! {} covers {}".format(p1_input, p2_input)
    elif p1_input == "Rock" and p2_input == "Paper":
        return "{} wins! {} covers {}".format(p2_name, p2_input, p1_input)

    # Rock crushes lizard
    elif p1_input == "Rock" and p2_input == "Lizard":
        return "You win! {} crushes {}".format(p1_input, p2_input)
    elif p1_input == "Lizard" and p2_input == "Rock":
        return "{} wins! {} crushes {}".format(p2_name, p2_input, p1_input)

    # Lizard poisons spock
    elif p1_input == "Lizard" and p2_input == "Spock":
        return "You win! {} poisons {}".format(p1_input, p2_input)
    elif p1_input == "Spock" and p2_input == "Lizard":
        return "{} wins! {} poisons {}".format(p2_name, p2_input, p1_input)

    # Spock smashes scissors
    elif p1_input == "Spock" and p2_input == "Scissors":
        return "You win! {} smashes {}".format(p1_input, p2_input)
    elif p1_input == "Scissors" and p2_input == "Spock":
        return "{} wins! {} smashes {}".format(p2_name, p2_input, p1_input)

    # Scissors decapitates lizard
    elif p1_input == "Scissors" and p2_input == "Lizard":
        return "You win! {} decapitates {}".format(p1_input, p2_input)
    elif p1_input == "Lizard" and p2_input == "Scissors":
        return "{} wins! {} decapitates {}".format(p2_name, p2_input, p1_input)

    # Lizard eats paper
    elif p1_input == "Lizard" and p2_input == "Paper":
        return "You win! {} eats {}".format(p1_input, p2_input)
    elif p1_input == "Paper" and p2_input == "Lizard":
        return "{} wins! {} eats {}".format(p2_name, p2_input, p1_input)

    # Paper disproves Spock
    elif p1_input == "Paper" and p2_input == "Spock":
        return "You win! {} disproves {}".format(p1_input, p2_input)
    elif p1_input == "Spock" and p2_input == "Paper":
        return "{} wins! {} disproves {}".format(p2_name, p2_input, p1_input)

    # Spock vaporizes Rock
    elif p1_input == "Spock" and p2_input == "Rock":
        return "You win! {} vaporizes {}".format(p1_input, p2_input)
    elif p1_input == "Rock" and p2_input == "Spock":
        return "{} wins! {} vaporizes {}".format(p2_name, p2_input, p1_input)

    # Rock Crushes scissors
    elif p1_input == "Rock" and p2_input == "Scissors":
        return "You win! {} crushes {}".format(p1_input, p2_input)
    elif p1_input == "Scissors" and p2_input == "Rock":
        return "{} wins! {} crushes {}".format(p2_name, p2_input, p1_input)

# This function Simulates a Player vs Computer Turn and returns the score of each turn


def PVC(scores):
    choice = ["Rock", "Paper", "Scissors", "Lizard", "Spock"]
    p1 = input("Your turn, Choose Rock, Paper, Scissors, Lizard, or Spock: ")
    p1 = p1.capitalize()

    while p1 not in choice:
        p1 = input("Your turn, Choose Rock, Paper, Scissors, Lizard, or Spock: ")
        p1 = p1.capitalize()
        if p1 in choice:
            break

    computer_input = "".join(random.choices(choice))
    print()

    for i in ["Rock", "Paper", "Scissors", "Lizard", "Spock", "!!!"]:
        print(i, end=" ")
        # Adds a time Delay when printing the message in between player inputs
        time.sleep(0.3)
    print()
    print("Computer chose: " + computer_input)

    if "You win" in outcomes(p1, computer_input, "Computer"):
        scores[0] += 1
    elif "Computer wins" in outcomes(p1, computer_input, "Computer"):
        scores[1] += 1
    return outcomes(p1, computer_input, "Computer")

# This function Simulates a Player vs Player Turn and returns the score of each turn


def PVP(scores):
    choices = ["Rock", "Paper", "Scissors", "Lizard", "Spock"]
    p1 = input("Your turn, Choose Rock, Paper, Scissors, Lizard, or Spock: ")
    p1 = p1.capitalize()
    while p1 not in choices:
        p1 = input("Your turn, Choose Rock, Paper, Scissors, Lizard, or Spock: ")
        p1 = p1.capitalize()
        if p1 in choices:
            break
    print()
    for i in ["Rock", "Paper", "Scissors", "Lizard", "Spock", "!!!"]:
        print(i, end=" ")
        time.sleep(0.3)
    print(22 * "\n")

    p2 = input(
        "Player 2's turn, choose Choose Rock, Paper, Scissors, Lizard, or Spock: ")
    p2 = p2.capitalize()
    while p2 not in choices:
        p2 = input(
            "Player 2's turn, choose Choose Rock, Paper, Scissors, Lizard, or Spock: ")
        p2 = p2.capitalize()
        if p2 in choices:
            break

# Checks the win text and increments the score up by 1
    if "You win!" in outcomes(p1, p2, player2name):
        scores[0] += 1
    elif "{} wins!".format(player2name) in outcomes(p1, p2, player2name):
        scores[1] += 1
    return outcomes(p1, p2, player2name)


player1_name = input(
    "Welcome to Rock paper Scissors!!!!!!!! Enter your name: ")
scoreboard = [0, 0]
print("Welcome, " + player1_name + "!")
Choose_game = int(
    input("Play with the computer or another player? Press 1 or 2: "))
if Choose_game == 1:
    done = False
    while not done:
        print(PVC(scoreboard))

        play_again = input("Play again? Y/N: ")
        play_again = play_again.capitalize()
        if play_again != "Y":
            done = True
    print("{} {} : Computer {} ".format(
        player1_name, scoreboard[0], scoreboard[1]))


else:
    player2name = input(
        "Welcome to Rock paper Scissors!!!!!!!! Enter your name: ")
    print("Welcome, " + player2name + "!")

    done = False
    while not done:
        print(PVP(scoreboard))
        play_again = input("Play again? Y/N: ")
        play_again = play_again.capitalize()
        if play_again != "Y":
            done = True
    print("{} {} , {} {}".format(player1_name,
                                 scoreboard[0], player2name, scoreboard[1]))
