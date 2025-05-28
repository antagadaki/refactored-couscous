from collections import deque
import random
import time

# Queues for flight control
landing_queue = deque()
emergency_queue = deque()
takeoff_queue = deque()

# Function to generate flight request
def generate_request():
    flight_id = random.randint(100, 999)
    request_type = random.choice(['landing', 'takeoff', 'emergency'])

    if request_type == 'landing':
        print(f"Flight {flight_id} requests landing")
        landing_queue.append(flight_id)
    elif request_type == 'emergency':
        print(f"Flight {flight_id} requests EMERGENCY landing")
        emergency_queue.appendleft(flight_id)
    else:
        print(f"Flight {flight_id} requests takeoff")
        takeoff_queue.append(flight_id)

# Function to process control decisions
def process_control():
    if emergency_queue:
        flight = emergency_queue.popleft()
        print(f"CONTROL: Flight {flight} land (EMERGENCY)")
    elif landing_queue:
        flight = landing_queue.popleft()
        print(f"CONTROL: Flight {flight} land")
    elif takeoff_queue:
        flight = takeoff_queue.popleft()
        print(f"CONTROL: Flight {flight} takeoff")
    else:
        print("CONTROL: No pending requests")

# Main simulation loop
def run_simulation(iterations=10, delay=1):
    for _ in range(iterations):
        generate_request()
        process_control()
        time.sleep(delay)

if __name__ == '__main__':
    run_simulation()