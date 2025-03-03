def plannedReleaseDate = '05/03/2025'
def dateFormat = new SimpleDateFormat('dd/MM/yyyy')
def plannedReleaseDate = dateFormat.parse(plannedReleaseDate)
def releaseNoteCreationTargetDate = dateFormat.parse(plannedReleaseDate) - 2
def releaseNoteCreationFormatedTargetDate = dateFormat.format(releaseNoteCreationTargetDate)

if (releaseNoteCreationFormatedTargetDate == today) {
  echo 'Good to go'
}
