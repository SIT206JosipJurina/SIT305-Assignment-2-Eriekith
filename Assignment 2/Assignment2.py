#Python Text RPG
#Josip Antony Jurina

import cmd
import textwrap
import sys
import os
import time
import random

screen_width = 100

###### Player Setup ######
class player:
	def _init_(self):
		self.name = ''
		self.hp = 0
		self.mp = 0
		self.status_effects = []

myPlayer = player()

###### Title Screen ######
def title_screen_selections():
	option = input("> ")
	if option.lower() == ("play"):
		start_game() #placeholder until written
	elif option.lower() == ("help"):
		help_menu()
	elif option.lower() == ("quit"):
		sys.exit()
	while option.lower() not in ['play', 'help', 'quit']:
		print("Please enter a valid command.")
		option = input("> ")
		if option.lower() == ("play"):
			start_game() #placeholder until written
		elif option.lower() == ("help"):
			help_menu()
		elif option.lower() == ("quit"):
			sys.exit()

def title_screen():
	os.system('clear')
	print('################################')
	print('# Welcome to my text RPG Game! #')
	print('################################')
	print('			 - Play -              ')
	print('			 - Help -			   ')
	print('			 - Quit -			   ')
	print('	 Copyright 2018 Josip Jurina   ')
	title_screen_selections()


def help_menu():
	print('################################')
	print('# Welcome to my text RPG Game! #')
	print('################################')
	print('	Use up, down, left, right to move')
	print('	You must type commands to move ')
	print(' Use "look"	to inspect when in new location')
	print('	Sneak ')
	print('	attack ')
	print('	hide ')
	print('	run ')
	title_screen_selections()