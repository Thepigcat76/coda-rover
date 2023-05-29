walk

walk(x) - possibly

turnLeft

turnRight

place Block, Marker

remove Block, Marker

stop

## conditions
(not)

(and)

(or)

istWall

isBlock

isMarker

istNorth, East, South, West

## control

if statements

    if condition:
        walk (optional Indentation)
    endIf

while loops

    repeat always:
        walk
    endRepeat

while loops (condition)

    repeat while condition:
        walk
    endRepeat

for loops

    repeat x times:
        walk
    endRepeat

## other

methods

    define name:
        walk
        walk
        turnLeft
    endDefine

    name
