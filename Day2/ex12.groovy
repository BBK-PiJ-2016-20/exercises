// It's unclear whether we're supposed to stop at any point; lets just do single digits
int i = 0
while (i < 10) {
	for (int j = 0; j < i; j++) {
		print i
	}
	println ""
	i++
}