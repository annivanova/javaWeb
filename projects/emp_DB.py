import csv
from random import randint
from operator import itemgetter, attrgetter
import itertools
sort_list=[]
rows = []
row = {'full_name': input('name:'), 'employee_id': input('id:'), 'emp_dept': input('dept:'), 'dept_sal':int(input()),'emp_sal': int(input())}
max_sal=4000
avg_sal=1000

def create__save_emp():
    max_Employees = 4
    for n in range(0, max_Employees):
        row = {'full_name': input('name:'), 'employee_id': input('id:'), 'emp_dept': input('dept:'),'dept_sal':int(input()),'emp_sal':int(input())}
        rows.append(row)
    print(rows)
    writer_file_name = open('employees.csv', 'w')
    fileWriter=csv.writer(writer_file_name)
    for row in rows:
        fileWriter.writerow([row['full_name'], row['employee_id'],row['emp_dept'], row['dept_sal'], row['emp_sal']])
    for row in rows:
        if row['dept_sal']==max_sal:
            sort_list.append(row['emp_dept'])
    sort_list.sort()
    print('first three depts with max salary for the month are:', sort_list)
    top3=sort_list[:3]
    print('here are the first three depts with max salary',top3)
    for row in rows:
        if row['emp_sal'] in row:
            sort_list.append(row['emp_sal'])
    sort_list.sort()
    top3_emp=sort_list[:2]
    print('first three employees with max_sal', top3_emp)
    for row in rows:
        if row['emp_sal'] < avg_sal:
            sort_list.append(row['emp_sal'])
    sort_list.sort()
    print('employees with minimum salary:', sort_list)
    writer_file_name.close()




if __name__ == '__main__':
  create__save_emp()