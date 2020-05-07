import re
from collections import defaultdict
from typing import Dict

with open('Day4.txt') as f:
    content = f.readlines()
    content = [line.strip() for line in content]
    content = sorted(content)


def calculate_sleep_schedule() -> Dict[int, Dict[int, int]]:
    guards: Dict[int, Dict[int, int]] = {}
    on_duty = 0

    sleeping_start = 0

    for event in content:
        matches = re.search(r'\[(\d+-(\d+)-(\d+) (\d+):(\d+))\] (.*)', event)
        (_, month, day, hour, minute, action) = matches.groups()

        if action == 'falls asleep':
            sleeping_start = int(minute)
        if action == 'wakes up':
            for m in range(sleeping_start, int(minute)):
                guards[on_duty][m] += 1
            sleeping_start = 0

        if "#" in event:
            guard = int(action.split(' ')[1].replace('#', ''))
            on_duty = guard
            if guard not in guards:
                guards[guard] = defaultdict(int)

    return guards


def part1():
    guards = calculate_sleep_schedule()
    max_count = -1
    max_minute = -1

    sum = defaultdict(int)
    for (guard, minutes) in guards.items():
        for (minute, count) in minutes.items():
            sum[guard] += count

    max_guard = sorted(sum, key=sum.get, reverse=True)[0]

    minutes = guards[max_guard]
    for (minute, count) in minutes.items():
        if count > max_count:
            max_count = count
            max_minute = minute

    return max_minute * max_guard


def part2():
    guards = calculate_sleep_schedule()

    max_count = -1
    max_minute = -1
    max_guard = -1

    for (guard, minutes) in guards.items():
        for (minute, count) in minutes.items():
            if count > max_count:
                max_guard = guard
                max_count = count
                max_minute = minute

    return max_minute * max_guard
