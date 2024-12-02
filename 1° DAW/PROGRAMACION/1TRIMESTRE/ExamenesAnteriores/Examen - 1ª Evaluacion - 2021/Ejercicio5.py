password=input("Introduce tu contraseña: ")

def test_capital():
    if password[0].isupper() and password[-1].isupper():
        return True
    else:
        return False


def test_num():
    test=0
    for a in password:
        if a.isdigit():
            test+=1
    if test>0: return True
    else: return False

def test_symb():
    test=0
    symbols=("._#")
    for a in password:
        if a in symbols:
            test+=1      
    if test>0: return True
    else: return False

if(test_capital()==True and test_num()==True and test_symb()==True):
    print(True)
else:
    print(False)