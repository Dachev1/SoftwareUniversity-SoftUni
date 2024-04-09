










   
            build.append(String.format(ConstantMessages.FINAL_CLIMBER_NAME, climber.getName()));
            build.append(System.lineSeparator());
            build.append(String.format(ConstantMessages.FINAL_CLIMBER_STRENGTH, climber.getStrength()));
            build.append(System.lineSeparator());
            if (climber.getRoster().getPeaks().isEmpty()) {
                build.append(String.format(ConstantMessages.FINAL_CLIMBER_PEAKS, "None"));

            } else {
                build.append(String.format(ConstantMessages.FINAL_CLIMBER_PEAKS,
                        String.join(ConstantMessages.FINAL_CLIMBER_FINDINGS_DELIMITER, climber.getRoster().getPeaks())));
            }
        }
        return build.toString();
    }
}