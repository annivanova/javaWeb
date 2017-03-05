import csv
from abc import ABCMeta
from operator import itemgetter, attrgetter
import itertools

rows=[]

def del_emp(id):
    for row in rows:
        if row['employee_id']==id:
            rows.remove(row)

def add_emp(row):
    rows.append(row)

def get_employee(id):
    for row in rows:
        if row['employee_id']==id:
            return row

def search_emp(id, name):
    for row in rows:
         if row['employee_id'] == id:
            print(row)
         if row['full_name']==name:
             print(row)
