val flightpath: List[(Double, Double)] = List(
  (57514, 18117),
  (55786, 16899),
  (53461, 16991),
  (52678, 17726),
  (52442, 21872),
  (53521, 22993),
  (54681, 21772),
  (55473, 23612),
  (55989, 22328),
  (56800, 21871),
  (56581, 19000),
)

thrust =! 1
setLevelPitch | waitFor(5)
for case (lat, lon) <- flightpath yield
  goToCoordinates(lat, lon)
While(Altitude < 1400){
  elevators =! PID(30, PitchAngle, 0.1, 0, 0.05)
}
setLevelPitch