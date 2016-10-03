from textstat.textstat import textstat
import pandas as pd
import numpy as np
from scipy import stats
import matplotlib.pyplot as plt

# easy = {}
# standard = {}
# hard = {}
# confusing = {}

# lines = [line.rstrip('\n').rstrip('\r') for line in open('phrases2.txt')]

# for phrase in lines:
#     score = textstat.flesch_reading_ease(phrase)
#     if score > 70:
#         easy[phrase] = score
#     elif score > 60:
#         standard[phrase] = score
#     elif score > 30:
#         hard[phrase] = score
#     else
#         confusing[phrase] = score

# print standard

flesch_reading_ease = []
flesch_kincaid_grade = []
gunning_fog = []
smog_index = []
automated_readability_index = []
coleman_liau_index = []
linsear_write_formula = []
dale_chall_readability_score = []

data = pd.read_csv('phrases2.txt', header = None, names = ['phrases'])
for phrase in data['phrases']:
    flesch_reading_ease.append(textstat.flesch_reading_ease(phrase))
    flesch_kincaid_grade.append(textstat.flesch_kincaid_grade(phrase))
    gunning_fog.append(textstat.gunning_fog(phrase))
    smog_index.append(textstat.smog_index(phrase))
    automated_readability_index.append(textstat.automated_readability_index(phrase))
    coleman_liau_index.append(textstat.coleman_liau_index(phrase))
    linsear_write_formula.append(textstat.linsear_write_formula(phrase))
    dale_chall_readability_score.append(textstat.dale_chall_readability_score(phrase))

data['flesch_reading_ease'] = flesch_reading_ease
data['flesch_kincaid_grade'] = flesch_kincaid_grade
data['gunning_fog'] = gunning_fog
data['smog_index'] = smog_index
data['automated_readability_index'] = automated_readability_index
data['coleman_liau_index'] = coleman_liau_index
data['linsear_write_formula'] = linsear_write_formula
data['dale_chall_readability_score'] = dale_chall_readability_score

standard = data.loc[(data['flesch_reading_ease'] < 70) & (data['flesch_reading_ease'] > 60)]['phrases'].values
pilot_phrases = np.random.choice(standard, 30, replace=False)
print pilot_phrases