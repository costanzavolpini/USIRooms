import time
import random

classSelected = "SI-008"
idRoom = "0000"
building = "Black Building"

dateFrom = '2015-09-15T00:00:00'
dateTo = '2016-06-15T00:00:00'

dateFrom = int(time.mktime(time.strptime(dateFrom, '%Y-%m-%dT%H:%M:%S')))
dateTo = int(time.mktime(time.strptime(dateTo, '%Y-%m-%dT%H:%M:%S')))


text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque viverra ut ipsum quis cursus. Donec sit amet tempor arcu. Quisque tempor vel est in aliquet. Nulla vitae arcu non ex mollis convallis a vel risus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Cras vitae lacinia erat. Morbi tempus pretium diam nec pulvinar. Morbi leo leo, eleifend in mattis eget, tincidunt vel nibh. Quisque vitae ornare sapien. Aliquam eget velit in orci mattis malesuada sed volutpat mauris. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Cras quis arcu massa. Etiam dui dui, tempus sit amet lorem id, lacinia tincidunt mi. Nullam semper porta mauris sit amet tincidunt. Etiam ut tortor vitae tortor dignissim fringilla. Aliquam ac enim id odio porttitor facilisis. Mauris sed nisi at tortor cursus vulputate ut fringilla nisl. In interdum a metus iaculis dignissim. Cras laoreet imperdiet elit, non dictum nisi tempus in. Etiam velit libero, posuere vel porttitor quis, porttitor consectetur purus. Ut vitae tortor ornare, viverra ex ut, hendrerit nulla. Quisque nunc ipsum, ornare nec varius et, semper et magna. Praesent nisl magna, sollicitudin tempor varius iaculis, lobortis a libero. Integer dapibus tristique quam in tincidunt. In neque sem, mollis non mi a, suscipit dapibus nulla. Curabitur varius, elit non vulputate vehicula, dui est congue urna, nec pellentesque nisi dui sit amet mauris. Pellentesque lorem leo, accumsan in enim sed, convallis mattis neque. Curabitur dignissim lacus odio, posuere euismod tortor eleifend ut. Sed aliquet erat vel augue hendrerit suscipit.".split()



date = dateFrom


print("{ \"data\": [", end="")

totalEvent = 0
while(date < dateTo):
    date = random.randint(date + 200, date + 500000)
    eventDuration = random.randint(3600, 3600*3)
    eventStart = time.strftime('%Y-%m-%dT%H:%M:%S+0000', time.gmtime(date))
    eventEnd = time.strftime('%Y-%m-%dT%H:%M:%S+0000', time.gmtime(date+eventDuration))

    title = ""
    for i in range(random.randint(1, 5)):
        title += text[random.randint(0, len(text)-1)] + " "
    title = title[:-1]

    description = ""
    for i in range(random.randint(1, 50)):
        description += text[random.randint(0, len(text)-1)] + " "
    description = description[:-1]


    short_name = text[random.randint(0, len(text)-1)]

    idOrganizer = random.randint(100000000, 99999999999999)

    emailOrganizer = text[random.randint(0, len(text)-1)]+"@"+text[random.randint(0, len(text)-1)]+".com"

    totalEvent += 1





    print("{", end="")
    print("\"updated\": \"2016-04-13T08:59:44+0000\",", end="")
    print("\"start\": \"" + eventStart + "\",", end="")
    print("\"end\": \"" + eventEnd + "\",", end="")
    print("\"course\": {", end="")
    print("\"id\": 35253499,", end="")
    print("\"name_it\": \""+title+"\",\"name_en\": \""+title+"\",", end="")
    print("\"description_it\": \"" + description + "\",\"description_en\": \"" + description + "\",", end="")
    print("\"semester_academic_year\": \"SP 2016\",\"links\": {\"self\": \"http://search.usi.ch/api/course/35253499\"},\"lecturers\": {\"data\": [{\"person\": {\"id\": \"414fbe48da94f28c810b0e4f1890647f\",\"first_name\": \"Mehdi\",\"last_name\": \"Jazayeri\",", end="")
    print("\"short_name\": \""+short_name+"\",", end="")
    print("\"emails\": [\""+emailOrganizer+"\"],", end="")
    print("\"links\": {\"self\": \"http://search.usi.ch/api/people/414fbe48da94f28c810b0e4f1890647f\",\"courses\": \"http://search.usi.ch/api/people/414fbe48da94f28c810b0e4f1890647f/courses\",\"publications\": \"http://search.usi.ch/api/people/414fbe48da94f28c810b0e4f1890647f/publications\",\"projects\": \"http://search.usi.ch/api/people/414fbe48da94f28c810b0e4f1890647f/projects\",\"schedules\": \"http://search.usi.ch/api/people/414fbe48da94f28c810b0e4f1890647f/schedules\"},\"phones\": {\"data\": [{\"internal\": \"4656\",\"official\": \"+41 58 666 4656\"}],\"meta\": {\"count\": 1}}},\"role\": {\"name_it_m\": \"Docente titolare del corso\",\"name_it_f\": \"Docente titolare del corso\",\"name_en_m\": \"Course director\",\"name_en_f\": \"Course director\"}},],\"meta\": {\"count\": 2}}},", end="")
    print("\"place\": {\"id\": 1487,\"office\": \""+classSelected+"\",\"floor\": \"0\",\"links\": {\"self\": \"http://search.usi.ch/api/place/1487\",\"schedules\": \"http://search.usi.ch/api/place/1487/schedules\"},\"building\": {\"name_it\": \""+building+"\",\"name_en\": \""+building+"\",\"address\": \"Via Buffi 13, 6904 Lugano\",\"venue\": \"Campus Lugano\"}}},", end="")
    print()

print("],\"meta\": {\"count\": " + str(totalEvent) + "}}", end="")
